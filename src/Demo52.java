/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 
 */
public class Demo52 {
	public static void main(String[] args) {
		System.out.println(match("abbbs".toCharArray(), "abb.s".toCharArray()));
	}

	public static boolean match(char[] str, char[] pattern) {
		// 边界判断
		if (str == null || pattern == null) {
			return false;
		}
		return match(str, pattern, 0, 0);
	}

	public static boolean match(char[] str, char[] pattern, int strIndex,
			int patternIndex) {
		if (strIndex == str.length && patternIndex == pattern.length) {
			return true;
		}
		if (patternIndex == pattern.length) {
			return false;
		}
		// 判断是否为*
		if (pattern.length > patternIndex + 1
				&& '*' == pattern[patternIndex + 1]) {
			if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
					|| (strIndex != str.length && pattern[patternIndex] == '.')) {
				return match(str, pattern, strIndex, patternIndex + 2) // 不消费*
						|| match(str, pattern, strIndex + 1, patternIndex) // 不一定是最后一次消费*
						|| match(str, pattern, strIndex + 1, patternIndex + 2);// 最后一次消费*
			} else {
				return match(str, pattern, strIndex, patternIndex + 2); // 无法消费*
			}
		}
		// 判断是否相等和是否为.
		if ((str.length > strIndex && str[strIndex] == pattern[patternIndex])
				|| (pattern.length > patternIndex && '.' == pattern[patternIndex])) {
			return match(str, pattern, strIndex + 1, patternIndex + 1);// 最后一次消费*

		}
		return false;
	}
}
