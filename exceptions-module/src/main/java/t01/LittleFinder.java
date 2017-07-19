package t01;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * Задание 1. Обработка исключительных ситуаций
 * Разработать приложение, позволяющее просматривать файлы и каталоги файловой
 * системы, а также создавать и удалять текстовые файлы. Для работы с текстовыми
 * файлами необходимо реализовать функциональность записи (дозаписи) в файл.
 * Требуется определить исключения для каждого слоя приложения и корректно их
 * обработать.
 */
public class LittleFinder {

    private final int CAPACITY = 1024;

    public String list(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) throw new FileNotFoundException();
        if (file.isDirectory()) {
            StringBuilder sb = new StringBuilder();
            String[] files = file.list();
            assert files != null;
            Arrays.stream(files).forEach(elem -> {
                sb.append(elem);
                sb.append("\n");
            });
            return sb.toString();
        } else {
            return read(file);
        }
    }

    private String read(File file) {
        ByteBuffer bf;
        byte[] bytes = null;
        try (FileChannel fc = new FileInputStream(file.getPath()).getChannel()) {
            if (fc.size() < Integer.MAX_VALUE) { // i hope that's enough :)
                bytes = new byte[(int) fc.size()];
                bf = ByteBuffer.allocate(CAPACITY);
                int pos = 0;
                while (fc.read(bf) > 0) {
                    bf.flip();
                    System.arraycopy(bf.array(), 0, bytes, pos, bf.limit());
                    pos += bf.limit();
                    bf.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert bytes != null;
        return new String(bytes);
    }

    public void write(String fileName, String text, StandardOpenOption openOption) {
        byte[] textArray = text.concat("\n").getBytes();
        try {
            Files.write(Paths.get(fileName), textArray, openOption);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFile(String fileName) {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("File already exists");
        }
    }

    public void deleteFile(String fileName) {
        Path path = Paths.get(fileName);
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws URISyntaxException {
        LittleFinder lf = new LittleFinder();
        if (args.length == 0) // if there is no args, just print current dir
            System.out.println(System.getProperty("user.dir"));

        // expects 4 args: "write", "text", "destination" and true/false value
        // which indicates on need to rewrite existing file
        if (args.length > 0 && args[0].equals("write")) {
            if (args.length == 4) {
                String text = args[1];
                String file = args[2];
                StandardOpenOption option = args[3].equals("true")
                        ? StandardOpenOption.APPEND
                        : StandardOpenOption.TRUNCATE_EXISTING;
                lf.write(file, text, option);
            }
        }

        if (args.length == 2 && args[0].equals("list")) {
            // if only one arg given, try to detect is file or dir, then print it
            try {
                System.out.println(lf.list(args[1]));
            } catch (FileNotFoundException e) {
                System.err.println("There is no file or dir.");
                e.printStackTrace();
            }
        }

        if (args.length == 2 && args[0].equals("touch"))
            lf.createFile(args[1]);

        if (args.length == 2 && args[0].equals("rm"))
            lf.deleteFile(args[1]);

        if (args.length == 3 && args[0].equals("write"))
            lf.deleteFile(args[1]);
    }

}