package geeks.companies.facebook;

import java.util.Stack;

public class FindAbsolutePath {
    public static void main(final String[] args) {
        final String absolutePath = "/abc/def/ghi";
        final String relativePath = ".././xyz/../../ust";
        System.out.println(new FindAbsolutePath().getAbsolutePath(absolutePath, relativePath));
    }

    private String getAbsolutePath(final String absolutePath,
                                   final String relativePath) {
        final Stack<String> stack = new Stack<>();
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < absolutePath.length(); i++) {
            if (absolutePath.charAt(i) == '/') {
                final String x = stringBuilder.toString();
                stringBuilder.delete(0, x.length());
                stack.push(x);
            } else {
                stringBuilder.append(absolutePath.charAt(i));
            }
        }
        final String abc = stringBuilder.toString();
        stack.push(abc);
        System.out.println(abc);
        stringBuilder.delete(0, abc.length());
        for (int i = 0; i < relativePath.length(); i++) {
            if (relativePath.charAt(i) == '/') {
                final String x = stringBuilder.toString();
                switch (x) {
                    case "..":
                        stack.pop();
                        break;
                    case ".":
                        break;
                    default:
                        stack.push(x);
                        break;
                }
                stringBuilder.delete(0, x.length());
            } else {
                stringBuilder.append(relativePath.charAt(i));
            }
        }
        final String x = stringBuilder.toString();
        switch (x) {
            case "..":
                stack.pop();
                break;
            case ".":
                break;
            default:
                stack.push(x);
                break;
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = result + "/" + stack.pop();
        }
        return result;
    }
}
