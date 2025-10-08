package priv.study.mine.oss;

import lombok.Getter;

/**
 * 文件类型美剧
 * 
 * @author JLian
 * @date 2025年10月07日
 */
@Getter
public enum FileType {

    DOCX("docx"),
    DOC("doc"),
    PDF("pdf"),
    PNG("png"),
    JPEG("jpeg"),
    JPG("jpg"),
    MP4("mp4"),
    MP3("mp3");

    private String type;

    FileType(String type) {
        this.type = type;
    }

}
