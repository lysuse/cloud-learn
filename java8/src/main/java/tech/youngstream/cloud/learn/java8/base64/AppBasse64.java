package tech.youngstream.cloud.learn.java8.base64;

import java.net.URL;
import java.util.Base64;

public class AppBasse64 {

    public static void main(String[] args) {
        try {
            URL myUrl = new URL("http://www.youngstream.tech");
            Base64.Encoder urlEncoder = Base64.getUrlEncoder();
            System.out.println("URL: "+ myUrl);
            String str = "thisIsAtTestString";
            Base64.Encoder encoder = Base64.getEncoder();

            byte[] urlEncoded = urlEncoder.encode(myUrl.toString().getBytes("UTF-8"));
            byte[] strEncoded = encoder.encode(str.getBytes("UTF-8"));

            System.out.println("Base64 Encoded URL : " + new String(urlEncoded,"UTF-8"));
            System.out.println("Base64 Encoded String : " + new String(strEncoded,"UTF-8"));

            Base64.Decoder urlDecoder = Base64.getUrlDecoder();
            Base64.Decoder decoder = Base64.getDecoder();

            byte[] urlDecoded = urlDecoder.decode(urlEncoded);
            byte[] strDecoded = decoder.decode(strEncoded);

            System.out.println("Base64 Decoded URL : " + new String(urlDecoded,"UTF-8"));
            System.out.println("Base64 Decoded String : " + new String(strDecoded,"UTF-8"));

            //base64 mime decoder encoder
            byte[] originStrBytes = "我们为什么需要缓存？假设我们有一个性能开销比较大的的计算属性 A，它需要遍历一个巨大的数组并做大量的计算".getBytes("UTF-8");

            Base64.Encoder mimeEncoder1 = Base64.getMimeEncoder(16, "\\".getBytes());
            byte[] originStrEncoded = mimeEncoder1.encode(originStrBytes);

            System.out.println("Original Str: "+ new String(originStrBytes,"UTF-8"));
            System.out.println("Base64 Encoded Str: "+ new String(originStrEncoded,"UTF-8"));

            Base64.Decoder mimeDecoder = Base64.getMimeDecoder();
            byte[] originStrEncoded2 = mimeDecoder.decode(originStrEncoded);
            System.out.println("Base64 Decoded Str: "+ new String(originStrEncoded2,"UTF-8"));

        } catch (Exception e) {

        }
    }
}
