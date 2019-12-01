/**
  This class represents a database.  There are many 
  competing threads wishing to read and write.  It is 
  acceptable to have multiple processes reading at the 
  same time, but if one thread is writing then no other 
  process may either read or write.
 */
public class Database
{
  private int readers; // number of active readers
 
  /**
    Initializes this database.
  */
  public Database()
  {
    this.readers = 0;
  }
 
  /**
    Read from this database.
 
    @param number Number of the reader.
  */
  public void read(int number)
  {
    synchronized(this)
    {
      this.readers++;
      System.out.println("Reader " + number + " starts reading.");
    }
 
    final int DELAY = 5000;
    try
    {
      Thread.sleep((int) (Math.random() * DELAY));
    }
    catch (InterruptedException e) {}
 
    synchronized(this)
    {
      System.out.println("Reader " + number + " stops reading.");
      this.readers--;
      if (this.readers == 0)
      {
        this.notifyAll();
      }
    }
  }
 
  /**
    Writes to this database.
 
    @param number Number of the writer.
  */
  public synchronized void write(int number)
  {
    while (this.readers != 0)
    {
      try
      {
        this.wait();
      }
      catch (InterruptedException e) {}
    }
    System.out.println("Writer " + number + " starts writing.");
 
    final int DELAY = 5000;
    try
    {
      Thread.sleep((int) (Math.random() * DELAY));
    }
    catch (InterruptedException e) {}
 
    System.out.println("Writer " + number + " stops writing.");
    this.notifyAll();
 }
}
