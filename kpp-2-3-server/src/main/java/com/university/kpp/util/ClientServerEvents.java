package com.university.kpp.util;

public enum ClientServerEvents {
    PANEL_VISIBLE("panelVisibleItemVisible"),
    PANEL_INVISIBLE("panelVisibleItemInvisible"),
    PANEL_TEXT_VISIBLE("panelTextItemEnable"),
    PANEL_TEXT_INVISIBLE("panelTextItemDisable"),
    PANEL_FONT_YELLOW("panelFontYellowItem"),
    PANEL_FONT_BLUE("panelFontBlueItem"),
    PANEL_FONT_RED("panelFontRedItem"),
    PANEL_FONT_WINDOWS("panelFontWindowsItem"),
    EXIT_APP("exitApp");

    private final String data;

    ClientServerEvents(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public static ClientServerEvents getEvent(String data) {
        for (ClientServerEvents event : ClientServerEvents.values()) {
            if (event.getData().equals(data)) {
                return event;
            }
        }
        return null;
    }
}
