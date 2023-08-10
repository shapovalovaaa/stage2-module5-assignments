package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Getter
@Setter
public class LocalProcessor {
    private List<String> stringList;
    private String processorName = "";
    private Long period = 10_000_000_000_000L;
    private String processorVersion = "";
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private StringBuilder builder;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap, List<String> stringList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.stringList = stringList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringList.stream()
                .filter(Objects::nonNull)
                .map(String::hashCode)
                .forEach(System.out::println);
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        builder = new StringBuilder(processorName);
        for (String s : stringList) {
            builder.append(s).append(' ');
        }
        processorName = builder.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            this.informationScanner = scanner;
            builder = new StringBuilder(processorVersion);
            while (scanner.hasNext()) {
                builder.append(scanner.nextLine());
            }
            processorVersion = builder.toString();
        }
    }
}