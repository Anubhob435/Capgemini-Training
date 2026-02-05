package practice.Batch1;

// Sport interface
interface Sport {
    void calculateAvgAge(int[] age);
    void retirePlayer(int id);
    void playerTransfer(int fee, int id);
}

// Cricket class implementing Sport interface
class Cricket implements Sport {
    private int[] playerIDs;
    
    // Constructor
    public Cricket() {
        playerIDs = new int[11];
        // Set all 11 elements to 1
        for (int i = 0; i < 11; i++) {
            playerIDs[i] = 1;
        }
        System.out.println("Cricket team formed with 11 players.");
    }
    
    // Calculate average age of players
    @Override
    public void calculateAvgAge(int[] age) {
        if (age == null || age.length == 0) {
            System.out.println("No players to calculate average age.");
            return;
        }
        
        int sum = 0;
        for (int a : age) {
            sum += a;
        }
        double avgAge = (double) sum / age.length;
        System.out.println("Average age of Cricket players: " + String.format("%.2f", avgAge) + " years");
    }
    
    // Retire a player
    @Override
    public void retirePlayer(int id) {
        if (id < 0 || id >= playerIDs.length) {
            System.out.println("Invalid player ID. Cannot retire player.");
            return;
        }
        
        if (playerIDs[id] == 1) {
            playerIDs[id] = 0; // Mark as retired
            System.out.println("Cricket player with ID " + id + " has retired.");
        } else {
            System.out.println("Cricket player with ID " + id + " is already retired.");
        }
    }
    
    // Transfer a player
    @Override
    public void playerTransfer(int fee, int id) {
        if (id < 0 || id >= playerIDs.length) {
            System.out.println("Invalid player ID. Cannot transfer player.");
            return;
        }
        
        if (playerIDs[id] == 1) {
            System.out.println("Cricket player with ID " + id + " transferred for a fee of $" + fee + ".");
        } else {
            System.out.println("Cricket player with ID " + id + " is not active and cannot be transferred.");
        }
    }
    
    // Get player IDs (for testing purposes)
    public int[] getPlayerIDs() {
        return playerIDs;
    }
}

// Football class implementing Sport interface
class Football implements Sport {
    private int[] playerIDs;
    
    // Constructor
    public Football() {
        playerIDs = new int[11];
        // Set all 11 elements to 1
        for (int i = 0; i < 11; i++) {
            playerIDs[i] = 1;
        }
        System.out.println("Football team formed with 11 players.");
    }
    
    // Calculate average age of players
    @Override
    public void calculateAvgAge(int[] age) {
        if (age == null || age.length == 0) {
            System.out.println("No players to calculate average age.");
            return;
        }
        
        int sum = 0;
        for (int a : age) {
            sum += a;
        }
        double avgAge = (double) sum / age.length;
        System.out.println("Average age of Football players: " + String.format("%.2f", avgAge) + " years");
    }
    
    // Retire a player
    @Override
    public void retirePlayer(int id) {
        if (id < 0 || id >= playerIDs.length) {
            System.out.println("Invalid player ID. Cannot retire player.");
            return;
        }
        
        if (playerIDs[id] == 1) {
            playerIDs[id] = 0; // Mark as retired
            System.out.println("Football player with ID " + id + " has retired.");
        } else {
            System.out.println("Football player with ID " + id + " is already retired.");
        }
    }
    
    // Transfer a player
    @Override
    public void playerTransfer(int fee, int id) {
        if (id < 0 || id >= playerIDs.length) {
            System.out.println("Invalid player ID. Cannot transfer player.");
            return;
        }
        
        if (playerIDs[id] == 1) {
            System.out.println("Football player with ID " + id + " transferred for a fee of $" + fee + ".");
        } else {
            System.out.println("Football player with ID " + id + " is not active and cannot be transferred.");
        }
    }
    
    // Get player IDs (for testing purposes)
    public int[] getPlayerIDs() {
        return playerIDs;
    }
}

// Main class to demonstrate the Cricket and Football teams
public class CricketFootball {
    public static void main(String[] args) {
        System.out.println("=== CRICKET AND FOOTBALL TEAMS ===\n");
        
        // Cricket Team
        System.out.println("--- CRICKET TEAM ---");
        Cricket cricketTeam = new Cricket();
        
        // Calculate average age of cricket players
        int[] cricketAges = {25, 28, 30, 22, 27, 29, 24, 26, 31, 23, 28};
        cricketTeam.calculateAvgAge(cricketAges);
        
        // Retire a cricket player
        System.out.println();
        cricketTeam.retirePlayer(5);
        
        // Transfer a cricket player
        System.out.println();
        cricketTeam.playerTransfer(50000, 3);
        
        // Try to transfer a retired player
        System.out.println();
        cricketTeam.playerTransfer(60000, 5);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Football Team
        System.out.println("--- FOOTBALL TEAM ---");
        Football footballTeam = new Football();
        
        // Calculate average age of football players
        int[] footballAges = {24, 26, 29, 21, 25, 27, 23, 28, 30, 22, 26};
        footballTeam.calculateAvgAge(footballAges);
        
        // Retire a football player
        System.out.println();
        footballTeam.retirePlayer(7);
        
        // Transfer a football player
        System.out.println();
        footballTeam.playerTransfer(75000, 2);
        
        // Try to transfer a retired player
        System.out.println();
        footballTeam.playerTransfer(80000, 7);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Additional demonstrations
        System.out.println("--- ADDITIONAL OPERATIONS ---");
        
        // Retire multiple cricket players
        cricketTeam.retirePlayer(0);
        cricketTeam.retirePlayer(1);
        
        // Transfer football players
        footballTeam.playerTransfer(90000, 9);
        footballTeam.playerTransfer(100000, 10);
        
        System.out.println("\nProgram completed successfully!");
    }
}
