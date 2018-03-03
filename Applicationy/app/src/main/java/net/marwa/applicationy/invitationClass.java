package net.marwa.applicationy;

/**
 * Created by reems on 03/03/18.
 */

public class invitationClass {

    public int typeOfInvitation;
    public String type;
    public String design;

    public invitationClass(int typeOfInvitation,String type,String design){
        this.typeOfInvitation=typeOfInvitation;
        this.type=type;
        this.design=design;
    }
}
 class invitationClassCard extends invitationClass{
    public int numberOfCopies;

    public invitationClassCard(int typeOfInvitation,String type,String design,int numberOfCopies){
        super( typeOfInvitation,type,design);
        this.numberOfCopies=numberOfCopies;
    }
    class invitationClassVideo extends invitationClass{

        String duration;
        public invitationClassVideo(int typeOfInvitation,String type,String design,String duration){
            super( typeOfInvitation,type,design);
            this.duration=duration;
        }
    }
}