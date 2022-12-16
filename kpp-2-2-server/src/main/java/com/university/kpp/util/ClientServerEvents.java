package com.university.kpp.util;

public enum ClientServerEvents {
    LABEL_DISABLE("labelCheckBoxDisable"),
    LABEL_ENABLE("labelCheckBoxEnable"),
    PANEL_VISIBLE("panelCheckBoxVisible"),
    PANEL_INVISIBLE("panelCheckBoxInvisible"),
    PANEL_RED("redPanelRadioButton"),
    PANEL_BLUE("bluePanelRadioButton"),
    PANEL_STANDARD("standardPanelRadioButton");

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
