package pages;

public class BasePage {

    public Header header;
    public SideBar sideBar;

    public BasePage() {
        this.header = new Header();
        this.sideBar = new SideBar();
    }
}

