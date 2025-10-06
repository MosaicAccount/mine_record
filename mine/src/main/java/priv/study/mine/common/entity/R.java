package priv.study.mine.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回结果
 *
 * @author JLian
* @date 2025年10月04日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {

    private String message;

    private T data;

    private boolean success;


    public static <T> R<T> success() {
        return R.<T>builder()
                .message("请求成功")
                .data(null)
                .success(true)
                .build();
    }

    public static <T> R<T> success(T data) {
        return R.<T>builder()
                .message("请求成功")
                .data(data)
                .success(true)
                .build();
    }

    public static <T> R<T> error(String message) {
        return R.<T>builder()
                .message(message)
                .success(false)
                .build();
    }

    public static <T> R<T> error() {
        return R.<T>builder()
                .message("请求失败")
                .data(null)
                .success(false)
                .build();
    }

}
