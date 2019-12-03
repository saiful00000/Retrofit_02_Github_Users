package com.example.retrofit_02_github_users;

class User {

    private String login;
    private int id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private String site_admin;

    public User(String login, int id, String avatar_url, String gravatar_id
            , String url, String html_url, String followers_url, String following_url
            , String gists_url, String starred_url, String subscriptions_url, String organizations_url
            , String repos_url, String events_url, String received_events_url, String type, String site_admin) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
        this.gravatar_id = gravatar_id;
        this.url = url;
        this.html_url = html_url;
        this.followers_url = followers_url;
        this.following_url = following_url;
        this.gists_url = gists_url;
        this.starred_url = starred_url;
        this.subscriptions_url = subscriptions_url;
        this.organizations_url = organizations_url;
        this.repos_url = repos_url;
        this.events_url = events_url;
        this.received_events_url = received_events_url;
        this.type = type;
        this.site_admin = site_admin;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getSite_admin() {
        return site_admin;
    }

}
