package structural_design_pattern.facade;

public class Client {
    public void share(String message) {
        SocialMediaShare socialMedia = new SocialMediaShare(new Twitter(), new Facebook(), new LinkedIn());
        socialMedia.share(message);
    }
}
