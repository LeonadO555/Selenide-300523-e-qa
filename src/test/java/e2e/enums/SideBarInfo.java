package e2e.enums;

import lombok.Getter;

@Getter
public enum SideBarInfo {
    ALLITEMS("inventory"),
    ABOUT("about"),
    LOGOUT("logout"),
    RESETAPPSTATE("reset");
    public final String value;


    SideBarInfo(String value) {
        this.value = value;
    }
}
