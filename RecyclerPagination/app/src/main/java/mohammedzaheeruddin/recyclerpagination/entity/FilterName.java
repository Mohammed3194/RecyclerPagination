package mohammedzaheeruddin.recyclerpagination.entity;

/**
 * Created by mohammedzaheeruddin on 25-Mar-18.
 */
public class FilterName {

    private String userId;
    private String profileImageUrl;
    private String userName;
    private Integer reputation;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String serName) {
        this.userName = serName;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }
}
