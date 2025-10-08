package priv.study.mine.oss.factory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import priv.study.mine.oss.StorageType;
import priv.study.mine.oss.strategy.FileStorage;

/**
 * 文件平台工厂类
 * 
 * @author JLian
 * @date 2025年10月07日
 */
public class FileStorageFactory {

    private final Map<StorageType, FileStorage> storageMap;

    public FileStorageFactory(List<FileStorage> fileStorages) {
        this.storageMap = fileStorages.stream()
                .collect(Collectors.toMap(FileStorage::getStorageType, Function.identity(), (o1, o2) -> o2));
    }

    public FileStorage getStorageType(StorageType storageType) {
        if (!storageMap.containsKey(storageType)) {
            throw new IllegalArgumentException("未找到对应的文件存储平台");
        }
        return storageMap.get(storageType);
    }

    public FileStorage getDefualtStorage() {
        return storageMap.get(StorageType.LOCAl);
    }


}
