package util;

import java.io.Serializable;

public record Rec(byte[] bytes, String str, String hex) implements Serializable {

}
