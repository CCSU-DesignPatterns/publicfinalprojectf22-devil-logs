/**
 * 
 */
package devillogs.logging;
import java.io.Serializable;

/**
 * @author ck
 *
 */
public class Level implements Serializable
{
    public static final Level OFF = new Level("None", Integer.MAX_VALUE);
    public static final Level High = new Level("None", Integer.MAX_VALUE/2);
    public static final Level Mid = new Level("None", Integer.MAX_VALUE/5);
    public static final Level Low = new Level("None", Integer.MAX_VALUE/10);
    
    /*
     * @param name - the name of the level.
     * @param priority - an integer value indicating importance or severity.
     */
    public Level(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    /*
     * Name associated with this level.
     *
     */
    private final String name;
    /*
     * Integer Priority. Used for sorting, filtering, grouping.
     */
    private final int priority;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Level)) {
            return false;
        }
        return ((Level) o).priority == this.priority;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.priority;
    }
    /**
     * Returns the string representation of this {@code Level} object. In
     * this case, it is the level's name.
     *
     * @return the string representation of this level.
     */
    @Override
    public final String toString() {
        return "[name : " + this.name + ", priority : "+ this.priority + "]" ;
    }
}



