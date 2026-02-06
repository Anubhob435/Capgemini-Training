package practice.Batch1;

import java.util.ArrayList;
import java.util.List;

public class LogsSort {
    
    /**
     * Filter logs by status (error/critical) and sort by date and time.
     * 
     * @param logs 2D array with [date, time, status, message]
     * @return Filtered and sorted logs
     */
    public static List<List<String>> filterAndSortLogs(List<List<String>> logs) {
        // Filter logs with status "error" or "critical"
        List<List<String>> filteredLogs = logs.stream()
            .filter(log -> log.get(2).equalsIgnoreCase("error") || 
                          log.get(2).equalsIgnoreCase("critical"))
            .toList();
        
        // Convert to mutable list for sorting
        List<List<String>> mutableList = new ArrayList<>(filteredLogs);
        
        // Sort by date first, then time (stable sort)
        mutableList.sort((log1, log2) -> {
            int dateComparison = compareDate(log1.get(0), log2.get(0));
            if (dateComparison != 0) {
                return dateComparison;
            }
            return compareTime(log1.get(1), log2.get(1));
        });
        
        return mutableList;
    }
    
    /**
     * Compare two date strings in DD-MM-YYYY format
     */
    private static int compareDate(String date1, String date2) {
        String[] parts1 = date1.split("-");
        String[] parts2 = date2.split("-");
        
        int day1 = Integer.parseInt(parts1[0]);
        int month1 = Integer.parseInt(parts1[1]);
        int year1 = Integer.parseInt(parts1[2]);
        
        int day2 = Integer.parseInt(parts2[0]);
        int month2 = Integer.parseInt(parts2[1]);
        int year2 = Integer.parseInt(parts2[2]);
        
        // Compare year first
        if (year1 != year2) {
            return Integer.compare(year1, year2);
        }
        // Then month
        if (month1 != month2) {
            return Integer.compare(month1, month2);
        }
        // Finally day
        return Integer.compare(day1, day2);
    }
    
    /**
     * Compare two time strings in HH:MM format
     */
    private static int compareTime(String time1, String time2) {
        String[] parts1 = time1.split(":");
        String[] parts2 = time2.split(":");
        
        int hours1 = Integer.parseInt(parts1[0]);
        int minutes1 = Integer.parseInt(parts1[1]);
        
        int hours2 = Integer.parseInt(parts2[0]);
        int minutes2 = Integer.parseInt(parts2[1]);
        
        // Compare hours first
        if (hours1 != hours2) {
            return Integer.compare(hours1, hours2);
        }
        // Then minutes
        return Integer.compare(minutes1, minutes2);
    }
    
    public static void main(String[] args) {
        // Sample test data
        List<List<String>> logs = List.of(
            List.of("15-02-2026", "10:30", "info", "System started"),
            List.of("15-02-2026", "10:45", "error", "Connection failed"),
            List.of("14-02-2026", "23:15", "critical", "Database down"),
            List.of("15-02-2026", "10:45", "critical", "Out of memory"),
            List.of("16-02-2026", "08:00", "error", "Timeout occurred"),
            List.of("14-02-2026", "23:15", "error", "Auth failed"),
            List.of("15-02-2026", "09:30", "warning", "High CPU usage")
        );
        
        List<List<String>> result = filterAndSortLogs(logs);
        
        System.out.println("Filtered and Sorted Logs:");
        for (List<String> log : result) {
            System.out.println(log);
        }
    }
}