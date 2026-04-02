class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + ":" + riskScore;
    }
}

public class RiskRanking {

    // 🔹 Bubble Sort (Ascending by riskScore)
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        System.out.print("\nBubble Sort (Ascending): ");
        printArray(arr);
        System.out.println("Swaps: " + swaps);
    }

    // 🔹 Insertion Sort (Descending by riskScore + accountBalance)
    public static void insertionSort(Client[] arr) {

        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                  (arr[j].riskScore < key.riskScore ||
                  (arr[j].riskScore == key.riskScore &&
                   arr[j].accountBalance < key.accountBalance))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.print("\nInsertion Sort (Descending): ");
        printArray(arr);
    }

    // 🔹 Print array
    public static void printArray(Client[] arr) {
        for (Client c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // 🔹 Top 10 highest risk clients
    public static void topRiskClients(Client[] arr) {
        System.out.print("\nTop High-Risk Clients: ");

        int limit = Math.min(10, arr.length);
        for (int i = 0; i < limit; i++) {
            System.out.print(arr[i].name + "(" + arr[i].riskScore + ") ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Client[] clients = {
            new Client("clientC", 80, 5000),
            new Client("clientA", 20, 2000),
            new Client("clientB", 50, 3000)
        };

        // Copy arrays (important!)
        Client[] bubbleArr = clients.clone();
        Client[] insertionArr = clients.clone();

        // Sorting
        bubbleSort(bubbleArr);
        insertionSort(insertionArr);

        // Top risk clients (after DESC sort)
        topRiskClients(insertionArr);
    }
}