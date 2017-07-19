package javase01.t06;


/**
 * <em>This class represents simple notebook with few abilities</em>
 * <ol>
 *     <li>Add entry</li>
 *     <li>Remove entry</li>
 *     <li>Edit entry</li>
 *     <li>View all entries</li>
 * </ol>
 *
 * @author daddyingrave
 */
public class Notebook {

    private Entry[] entries;
    private int count;

    /**
     * Sets the initial size of notebook.
     *
     * @param noteBookSize size of entries array
     */
    public Notebook(int noteBookSize) {
        entries = new Entry[noteBookSize];
    }

    /**
     * Adds new entry to notebook with specified title and content.
     *
     * @param title
     * @param content
     */
    public void addEntry(String title, String content) {
        if (entries.length >= count) {
            entries[count++] = new Entry(title, content);
            System.out.println("Entry added.");
            return;
        }
        enlargeNotebook();
    }

    /**
     * Adds new entry to notebook with generic title ("No Title") and given content.
     *
     * @param content
     */
    public void addEntry(String content) {
        if (entries.length >= count) {
            entries[count++] = new Entry("No Title", content);
            System.out.println("Entry added.");
            return;
        }
        enlargeNotebook();
    }

    /**
     * Deletes entry with given index.
     *
     * @param index
     */
    public void deleteEntryByIndex(int index) {
        if (!checkBounds(index)) return;
        deleteEntry(index);
        count--;
        System.out.println("Entry deleted.");
    }

    /**
     * Deletes entry with given title.
     *
     * @param title
     */
    public void deleteEntryByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (entries[i].getTitle().equals(title)) {
                deleteEntry(i);
                count--;
                System.out.println("Entry deleted");
                return;
            }
        }
        System.out.println("There are no entry in this notebook with such title.");
    }

    /**
     * Edits entry with given index.
     *
     * @param index
     * @param title if null, target value won't modify.
     * @param content if null, target value won't modify.
     */
    public void editEntryByIndex(int index, String title, String content) {
        if (!checkBounds(index)) return;
        if (title != null) {
            entries[index].setTitle(title);
            System.out.println("Title updated.");
        }
        if (content != null) {
            entries[index].setContent(content);
            System.out.println("Content updated.");
        }
    }

    /**
     * Edits entry with given title.
     *
     * @param title
     * @param newTitle if null, target value won't modify.
     * @param content if null, target value won't modify.
     */
    public void editEntryByTitle(String title, String newTitle, String content) {
        Entry entry = getEntry(title);
        if (entry != null) {
            if (content != null) {
                entry.setContent(content);
                System.out.println("Content updated.");
            }
            if (newTitle != null) {
                entry.setTitle(newTitle);
                System.out.println("Title updated.");
            }
        } else {
            System.out.println("There are no entry in this notebook with such title.");
        }
    }

    /**
     * Prints all entries to console.
     */
    public void viewAllEntries() {
        if (count == 0) return;
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null) return;
            System.out.println("Entry #" + (i + 1) + ": " + entries[i]);
        }
    }

    public int getCount() {
        return count;
    }

    public int getEntriesLength() {
        return entries.length;
    }

    private void enlargeNotebook() {
        Entry[] newArray = new Entry[entries.length * 3 / 2 + 1];
        System.arraycopy(entries, 0, newArray, 0, entries.length);
        entries = newArray;
        System.out.println("Notebook is full. But we enlarge it! Now its max size is " + entries.length);
    }

    private Entry getEntry(String title) {
        for (int i = 0; i < count; i++) {
            if (entries[i].getTitle().equals(title)) {
                return entries[i];
            }
        }
        return null;
    }

    private boolean checkBounds(int index) {
        if (index < 0 || index > count) {
            System.out.println("There are no entry in this notebook with such index.");
            return false;
        }
        return true;
    }

    private void deleteEntry(int index) {
        Entry[] newArray = new Entry[entries.length - 1];
        System.arraycopy(entries, 0, newArray, 0, index);
        System.arraycopy(entries, index + 1, newArray, index, entries.length - index - 1);
        entries = newArray;
    }

}

class Entry {

    private String title;
    private String content;

    public Entry(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public Entry setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Entry setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return "title: " + title +
                ", content: " + content + ' ';
    }
}