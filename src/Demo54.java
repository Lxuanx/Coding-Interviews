/**
 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
 * ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
 * 
 */
public class Demo54 {
	StringBuffer s = new StringBuffer();
	int[] hashtable = new int[256];

	// Insert one char from stringstream
	public void Insert(char ch) {
		s.append(ch);
		++hashtable[ch];
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		char[] chars = s.toString().toCharArray();
		for(char c : chars){
			if(hashtable[c] == 1){
				return c;
			}
		}
		return '#';
	}
}