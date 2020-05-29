package com.ruoyi.web.controller.tool.entity.webServiceUtils;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

    /**
     * MD5����/��֤������
     *
     */
    public class MD5Utils {

        static final char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        static final char hexDigitsLower[] = { '0', '1', '2', '3', '4', '5', '6', '7','8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

        /**
         *   ���ַ��� MD5 ����ֵ����
         *
         * @param plainText
         * 		����Ҫ���ܵ��ַ���
         * @return
         *  	MD5���ܺ�����32λ(Сд��ĸ+����)�ַ���
         */
        public static String MD5Lower(String plainText) {
            try {
                // ���MD5ժҪ�㷨�� MessageDigest ����
                MessageDigest md = MessageDigest.getInstance("MD5");

                // ʹ��ָ�����ֽڸ���ժҪ
                md.update(plainText.getBytes());

                // digest()���ȷ������md5 hashֵ������ֵΪ8λ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
                // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ��1 �̶�ֵ
                return new BigInteger(1,  md.digest()).toString(16);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }



        /**
         *  ���ַ��� MD5 ����
         *
         * @param plainText
         * 		����Ҫ���ܵ��ַ���
         * @return
         * 		MD5���ܺ�����32λ(��д��ĸ+����)�ַ���
         */
        public static String MD5Upper(String plainText) {
            try {
                // ���MD5ժҪ�㷨�� MessageDigest ����
                MessageDigest md = MessageDigest.getInstance("MD5");

                // ʹ��ָ�����ֽڸ���ժҪ
                md.update(plainText.getBytes());

                // �������
                byte[] mdResult = md.digest();
                // ������ת����ʮ�����Ƶ��ַ�����ʽ
                int j = mdResult.length;
                char str[] = new char[j * 2];
                int k = 0;
                for (int i = 0; i < j; i++) {
                    byte byte0 = mdResult[i];
                    str[k++] = hexDigits[byte0 >>> 4 & 0xf];// ȡ�ֽ��и� 4 λ������ת��, >>> Ϊ�߼����ƣ�������λһ������
                    str[k++] = hexDigits[byte0 & 0xf]; // ȡ�ֽ��е� 4 λ������ת��
                }
                return new String(str);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /**
         *   ���ַ��� MD5 ����ֵ����
         *
         * @param plainText
         * 		����Ҫ���ܵ��ַ���
         * @param saltValue
         * 		����Ҫ�ӵ���ֵ
         * @return
         *  	MD5���ܺ�����32λ(Сд��ĸ+����)�ַ���
         */
        public static String MD5Lower(String plainText, String saltValue) {
            try {
                // ���MD5ժҪ�㷨�� MessageDigest ����
                MessageDigest md = MessageDigest.getInstance("MD5");

                // ʹ��ָ�����ֽڸ���ժҪ
                md.update(plainText.getBytes());
                md.update(saltValue.getBytes());

                // digest()���ȷ������md5 hashֵ������ֵΪ8λ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
                // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ��1 �̶�ֵ
                return new BigInteger(1,  md.digest()).toString(16);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }

        /**
         *   ���ַ��� MD5 ����ֵ����
         *
         * @param plainText
         * 		����Ҫ���ܵ��ַ���
         * @param saltValue
         * 		����Ҫ�ӵ���ֵ
         * @return
         *  	MD5���ܺ�����32λ(��д��ĸ+����)�ַ���
         */
        public static String MD5Upper(String plainText, String saltValue) {
            try {
                // ���MD5ժҪ�㷨�� MessageDigest ����
                MessageDigest md = MessageDigest.getInstance("MD5");

                // ʹ��ָ�����ֽڸ���ժҪ
                md.update(plainText.getBytes());
                md.update(saltValue.getBytes());

                // �������
                byte[] mdResult = md.digest();
                // ������ת����ʮ�����Ƶ��ַ�����ʽ
                int j = mdResult.length;
                char str[] = new char[j * 2];
                int k = 0;
                for (int i = 0; i < j; i++) {
                    byte byte0 = mdResult[i];
                    str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                    str[k++] = hexDigits[byte0 & 0xf];
                }
                return new String(str);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /**
         *  MD5���ܺ�����32λ(Сд��ĸ+����)�ַ���
         *    ͬ MD5Lower() һ��
         */
        public final static String MD5(String plainText) {
            try {
                MessageDigest mdTemp = MessageDigest.getInstance("MD5");

                mdTemp.update(plainText.getBytes("UTF-8"));

                byte[] md = mdTemp.digest();
                int j = md.length;
                char str[] = new char[j * 2];
                int k = 0;
                for (int i = 0; i < j; i++) {
                    byte byte0 = md[i];
                    str[k++] = hexDigitsLower[byte0 >>> 4 & 0xf];
                    str[k++] = hexDigitsLower[byte0 & 0xf];
                }
                return new String(str);
            } catch (Exception e) {
                return null;
            }
        }

        /**
         *  У��MD5��
         *
         * @param text
         *      	ҪУ����ַ���
         * @param md5
         *            md5ֵ
         * @return У����
         */
        public static boolean valid(String text, String md5) {
            return md5.equals(MD5(text)) || md5.equals(MD5(text).toUpperCase());
        }


        /**
         * ����
         * @param args
         */
        public static void main(String[] args) {
            String plainText = "admin";
            String saltValue = "admin123";

            System.out.println(MD5Lower(plainText));
            System.out.println(MD5Upper(plainText));
            System.out.println(MD5Lower(plainText, saltValue));
            System.out.println(MD5Upper(plainText, saltValue));
            System.out.println(MD5(plainText));
            System.out.println("=====У����======");
            System.out.println(valid(plainText,MD5(plainText)));

        }
    }

