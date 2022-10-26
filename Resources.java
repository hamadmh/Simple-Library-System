interface Resources {

    Resources add(String title, String author, boolean available);

    public String getTitle();

    public void setTitle(String title);

    public String getAuthor();

    public void setAuthor(String author);


    public void attach(borrower o);
      
    
 
    public void detach(borrower o);
    
    
 
    public static void notifyUpdate(Message m){};
      
    

}
