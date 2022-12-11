package librarymanagement;


public class Members {

    private int id;
    private String member_fullname;
    private String member_phone;
    private String member_address;
    private String member_email;
    private String member_gender;

    public Members (int id, String member_fullname, String member_phone, String member_address, String member_email, String member_gender){
        this.id=id;
        this.member_fullname = member_fullname;
        this.member_phone=member_phone;
        this.member_address=member_address;
        this.member_email=member_email;
        this.member_gender=member_gender;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getMember_fullname(){
        return member_fullname;
    }

    public void setMember_fullname(String member_fullname){
        this.member_fullname = member_fullname;
    }

    public String getMember_phone(){
        return member_phone;
    }

    public void setMember_phone(String member_phone){
        this.member_phone = member_phone;
    }


    public String getMember_address(){
        return member_address;
    }

    public void setMember_address(String member_address){
        this.member_address = member_address;
    }

    public String getMember_email(){
        return member_email;
    }

    public void setMember_email(String member_email){
        this.member_email = member_email;
    }


    public String getMember_gender(){
        return member_gender;
    }

    public void setMember_gender(String member_gender){
        this.member_gender = member_gender;
    }



}


