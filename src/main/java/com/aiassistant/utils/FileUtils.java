import com.aiassistant.model.LotteryEntry;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static List<LotteryEntry> parseExcelFile(MultipartFile file) throws IOException {
        List<LotteryEntry> lotteryEntries = new ArrayList<>();

        try (InputStream inputStream = file.getInputStream(); Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header
                LotteryEntry entry = new LotteryEntry();
                entry.setName(row.getCell(0).getStringCellValue());
                entry.setEmployeeId(row.getCell(1).getStringCellValue());
                lotteryEntries.add(entry);
            }
        }

        return lotteryEntries;
    }
}
