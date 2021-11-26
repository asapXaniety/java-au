public enum FileType {
    MARKDOWN("md"),
    HTML("html"),
    LATEX("tex");
    private String type;
    FileType(String type) {
        this.type = type;
    }
    public String getValue(){
        return type;
    }
}