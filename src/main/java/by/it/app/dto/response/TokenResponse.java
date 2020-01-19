package by.it.app.dto.response;

/**
 * The type Token response.
 */
public class TokenResponse {

    private String accessToken;

    private String type = "Bearer";

    /**
     * Instantiates a new Token response.
     *
     * @param accessToken the access token
     */
    public TokenResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Gets access token.
     *
     * @return the access token
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Sets access token.
     *
     * @param accessToken the access token
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }
}
