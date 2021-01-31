package org.jac.java.v15.features;

public class StringBlocks {
    String htmlWithoutBlocks = "<html>\n" +
            "    <body>\n" +
            "        <p>Hello, world</p>\n" +
            "    </body>\n" +
            "</html>\n";

    String htmlWithBlocks = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;
}
