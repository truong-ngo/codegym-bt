package structural_design_pattern.facade;

public class SocialMediaShare {
    private Twitter twitter;
    private Facebook facebook;
    private LinkedIn linkedIn;

    public SocialMediaShare(Twitter twitter, Facebook facebook, LinkedIn linkedIn) {
        this.twitter = twitter;
        this.facebook = facebook;
        this.linkedIn = linkedIn;
    }

    public void share(String message) {
        twitter.setMessage(message);
        facebook.setMessage(message);
        linkedIn.setMessage(message);
        twitter.share();
        facebook.share();
        linkedIn.share();
    }
}
