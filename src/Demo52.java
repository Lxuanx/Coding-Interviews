/**
 * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ���
 * �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
 * 
 */
public class Demo52 {
	public static void main(String[] args) {
		System.out.println(match("abbbs".toCharArray(), "abb.s".toCharArray()));
	}

	public static boolean match(char[] str, char[] pattern) {
		// �߽��ж�
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
		// �ж��Ƿ�Ϊ*
		if (pattern.length > patternIndex + 1
				&& '*' == pattern[patternIndex + 1]) {
			if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
					|| (strIndex != str.length && pattern[patternIndex] == '.')) {
				return match(str, pattern, strIndex, patternIndex + 2) // ������*
						|| match(str, pattern, strIndex + 1, patternIndex) // ��һ�������һ������*
						|| match(str, pattern, strIndex + 1, patternIndex + 2);// ���һ������*
			} else {
				return match(str, pattern, strIndex, patternIndex + 2); // �޷�����*
			}
		}
		// �ж��Ƿ���Ⱥ��Ƿ�Ϊ.
		if ((str.length > strIndex && str[strIndex] == pattern[patternIndex])
				|| (pattern.length > patternIndex && '.' == pattern[patternIndex])) {
			return match(str, pattern, strIndex + 1, patternIndex + 1);// ���һ������*

		}
		return false;
	}
}
