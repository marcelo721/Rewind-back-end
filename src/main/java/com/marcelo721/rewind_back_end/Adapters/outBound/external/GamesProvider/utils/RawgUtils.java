package com.marcelo721.rewind_back_end.Adapters.outBound.external.GamesProvider.utils;

import java.time.LocalDate;

public class RawgUtils {
    public static String cleanHtml(String html) {
        return html != null
                ? html.replaceAll("<[^>]*>", "")
                : null;
    }

    public static LocalDate parseDate(String date) {
        try {
            return (date != null && !date.isEmpty())
                    ? LocalDate.parse(date)
                    : null;
        } catch (Exception e) {
            return null;
        }
    }
}
