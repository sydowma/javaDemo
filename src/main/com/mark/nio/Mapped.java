package main.com.mark.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Mapped {

    public static void main(String[] args) throws IOException {
        File tmp = Paths.get("/Users/mark/Github/javaDemo/src/main/com/mark/nio/tmp").toFile();


//        for (int i = 1; i < 10000; i++) {
//            writeToShareMemory(tmp, i, (byte) i);
//        }
        // 27s

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < 100000000; i++) {
            stringBuilder.append(i);
        }

        // 0

        long start = System.currentTimeMillis();

        // 1000ms
//        Files.write(Paths.get(tmp.toString(), "sharedmemory.txt"), stringBuilder.toString().getBytes(StandardCharsets.UTF_8));

//        System.out.println(stringBuilder.toString().getBytes(StandardCharsets.UTF_8).length);
        // 3366ms 900M
//        writeToShareMemory(tmp, stringBuilder.toString().getBytes(StandardCharsets.UTF_8));

        // 1727
        writeToShareMemoryWithFileChannel(tmp, stringBuilder.toString().getBytes(StandardCharsets.UTF_8));

        System.out.println("time = " + (System.currentTimeMillis() - start));

    }

    private static void writeToShareMemoryWithFileChannel(File tmp, byte[] bytes) throws IOException {
        try (FileChannel fileChannel = new RandomAccessFile(new File(tmp, "sharedmemory.txt"), "rw").getChannel()) {
            fileChannel.write(ByteBuffer.wrap(bytes));
        }
    }

    private static void writeToShareMemory(File tmpDir, int offset, byte value) throws IOException {
        try (RandomAccessFile sharedMemory = new RandomAccessFile(new File(tmpDir, "sharedmemory.txt"), "rw")) {
            // Using values from org.sonar.process.ProcessCommands
            MappedByteBuffer mappedByteBuffer = sharedMemory.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 1L * 15000);

            // Now we are stopping all processes as quick as possible
            // by asking for stop of "app" process
            mappedByteBuffer.put(offset, value);
        }
    }

    private static void writeToShareMemory(File tmpDir, byte[] value) throws IOException {
        try (RandomAccessFile sharedMemory = new RandomAccessFile(new File(tmpDir, "sharedmemory.txt"), "rw")) {
            // Using values from org.sonar.process.ProcessCommands
            MappedByteBuffer mappedByteBuffer = sharedMemory.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 788888889);

            // Now we are stopping all processes as quick as possible
            // by asking for stop of "app" process
            mappedByteBuffer.put(value);
            mappedByteBuffer.force();
        }
    }
}
