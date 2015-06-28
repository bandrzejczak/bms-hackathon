package pl.com.bms.api;

class Redirection {
    private final String uri;

    private Redirection(String uri) {
        this.uri = uri;
    }

    public String asString() {
        return "redirect:"+uri;
    }

    public static Redirection toIdeaDetails(String ideaId){
        return new Redirection("/idea/"+ideaId);
    }

    public static Redirection toApprovals() {
        return new Redirection("/approvals");
    }

}
