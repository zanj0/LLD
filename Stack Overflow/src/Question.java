public class Question implements Search{
    private String title;
    private String description;
    private int viewCount;
    private int voteCount;
    private Date creationDate;
    private Date updateTime;
    private QuestionStatus status;
    private QuestionClosingRemark closingRemark;
    private Member askingMember;
    private Bounty bounty;
    private List <Photo> photos;
    private List <Comment> comments;
    private List <Answer> answers;
    public boolean close();
    public boolean undelete();
    public boolean addComment();
    public boolean addComment();
    public boolean addBounty();
    public static List<Question> search(String query){

    }
}
