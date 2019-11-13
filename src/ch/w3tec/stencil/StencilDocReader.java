package ch.w3tec.stencil;

import ch.w3tec.stencil.dto.StencilDoc;
import com.google.gson.Gson;
import java.io.FileNotFoundException;

public class StencilDocReader {

    static String content = "{\n" +
            "  \"timestamp\": \"2019-11-11T13:09:12\",\n" +
            "  \"compiler\": {\n" +
            "    \"name\": \"@stencil/core\",\n" +
            "    \"version\": \"1.7.4\",\n" +
            "    \"typescriptVersion\": \"3.6.3\"\n" +
            "  },\n" +
            "  \"components\": [\n" +
            "    {\n" +
            "      \"filePath\": \"src/components/bal-button/bal-button.tsx\",\n" +
            "      \"encapsulation\": \"shadow\",\n" +
            "      \"tag\": \"bal-button\",\n" +
            "      \"readme\": \"# Button\\n\\nThe classic button, in different colors, sizes, and states\\n\\n## Basics\\n\\n```html\\n<bal-button type=\\\"is-primary\\\">Primary</bal-button>\\n<bal-button type=\\\"is-info\\\">Info</bal-button>\\n<bal-button type=\\\"is-success\\\">Success</bal-button>\\n<bal-button type=\\\"is-warning\\\">Warning</bal-button>\\n<bal-button type=\\\"is-danger\\\">Danger</bal-button>\\n<bal-button type=\\\"is-link\\\">Link</bal-button>\\n```\\n\\n## Outlined\\n\\n```html\\n<bal-button type=\\\"is-primary is-outlined\\\">Primary</bal-button>\\n<bal-button type=\\\"is-info is-outlined\\\">Info</bal-button>\\n<bal-button type=\\\"is-success is-outlined\\\">Success</bal-button>\\n<bal-button type=\\\"is-warning is-outlined\\\">Warnung</bal-button>\\n<bal-button type=\\\"is-danger is-outlined\\\">Danger</bal-button>\\n```\\n\\n## Inverted\\n\\n```html\\n<div class=\\\"has-inverted-background\\\">\\n  <bal-button type=\\\"is-primary is-inverted\\\">Primary</bal-button>\\n  <bal-button type=\\\"is-info is-inverted\\\">Info</bal-button>\\n  <bal-button type=\\\"is-info is-inverted is-outlined\\\">Info Outlined</bal-button>\\n</div>\\n```\\n\\n## Disabled\\n\\n```html\\n<bal-button type=\\\"is-primary\\\" disabled>Primary</bal-button>\\n<bal-button type=\\\"is-info\\\" disabled>Info</bal-button>\\n<bal-button type=\\\"is-success\\\" disabled>Success</bal-button>\\n<bal-button type=\\\"is-warning\\\" disabled>Warning</bal-button>\\n<bal-button type=\\\"is-danger\\\" disabled>Danger</bal-button>\\n<bal-button type=\\\"is-link\\\" disabled>Link</bal-button>\\n```\\n\\n## Loading\\n\\n```html\\n<bal-button type=\\\"is-primary\\\" loading>Primary</bal-button>\\n<bal-button type=\\\"is-info\\\" loading>Info</bal-button>\\n<bal-button type=\\\"is-success\\\" loading>Success</bal-button>\\n<bal-button type=\\\"is-warning\\\" loading>Warning</bal-button>\\n<bal-button type=\\\"is-danger\\\" loading>Danger</bal-button>\\n```\\n\",\n" +
            "      \"docs\": \"The classic button, in different colors, sizes, and states\",\n" +
            "      \"docsTags\": [],\n" +
            "      \"usage\": {},\n" +
            "      \"props\": [\n" +
            "        {\n" +
            "          \"name\": \"disabled\",\n" +
            "          \"type\": \"boolean\",\n" +
            "          \"mutable\": false,\n" +
            "          \"attr\": \"disabled\",\n" +
            "          \"reflectToAttr\": false,\n" +
            "          \"docs\": \"If `true` the button is disabled\",\n" +
            "          \"docsTags\": [],\n" +
            "          \"values\": [\n" +
            "            {\n" +
            "              \"type\": \"boolean\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"optional\": false,\n" +
            "          \"required\": false\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"loading\",\n" +
            "          \"type\": \"boolean\",\n" +
            "          \"mutable\": false,\n" +
            "          \"attr\": \"loading\",\n" +
            "          \"reflectToAttr\": false,\n" +
            "          \"docs\": \"If `true` the label is hidden and a loading spinner is shown instead.\",\n" +
            "          \"docsTags\": [],\n" +
            "          \"values\": [\n" +
            "            {\n" +
            "              \"type\": \"boolean\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"optional\": false,\n" +
            "          \"required\": false\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"type\",\n" +
            "          \"type\": \"\\\"is-danger\\\" | \\\"is-info\\\" | \\\"is-link\\\" | \\\"is-primary\\\" | \\\"is-success\\\" | \\\"is-warning\\\"\",\n" +
            "          \"mutable\": false,\n" +
            "          \"attr\": \"type\",\n" +
            "          \"reflectToAttr\": false,\n" +
            "          \"docs\": \"The theme type of the button. Given by bulma our css framework.\",\n" +
            "          \"docsTags\": [],\n" +
            "          \"default\": \"\\\"is-primary\\\"\",\n" +
            "          \"values\": [\n" +
            "            {\n" +
            "              \"value\": \"is-danger\",\n" +
            "              \"type\": \"string\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"value\": \"is-info\",\n" +
            "              \"type\": \"string\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"value\": \"is-link\",\n" +
            "              \"type\": \"string\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"value\": \"is-primary\",\n" +
            "              \"type\": \"string\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"value\": \"is-success\",\n" +
            "              \"type\": \"string\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"value\": \"is-warning\",\n" +
            "              \"type\": \"string\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"optional\": false,\n" +
            "          \"required\": false\n" +
            "        }\n" +
            "      ],\n" +
            "      \"methods\": [],\n" +
            "      \"events\": [],\n" +
            "      \"styles\": [],\n" +
            "      \"slots\": [],\n" +
            "      \"dependents\": [],\n" +
            "      \"dependencies\": [\n" +
            "        \"bal-spinner\"\n" +
            "      ],\n" +
            "      \"dependencyGraph\": {\n" +
            "        \"bal-button\": [\n" +
            "          \"bal-spinner\"\n" +
            "        ]\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"filePath\": \"src/components/bal-spinner/bal-spinner.tsx\",\n" +
            "      \"encapsulation\": \"shadow\",\n" +
            "      \"tag\": \"bal-spinner\",\n" +
            "      \"readme\": \"# Spinner\\n\\nA simple loading spinner.\\n\\n## Basic\\n\\n```html\\n<bal-spinner></bal-spinner>\\n```\\n\\n## Small\\n\\n```html\\n<bal-spinner class=\\\"is-small\\\"></bal-spinner>\\n```\\n\\n## Inverted\\n\\n```html\\n<div class=\\\"has-background-info is-padded\\\">\\n  <bal-spinner class=\\\"is-inverted\\\"></bal-spinner>\\n</div>\\n```\\n\",\n" +
            "      \"docs\": \"A simple loading spinner.\",\n" +
            "      \"docsTags\": [],\n" +
            "      \"usage\": {},\n" +
            "      \"props\": [],\n" +
            "      \"methods\": [],\n" +
            "      \"events\": [],\n" +
            "      \"styles\": [],\n" +
            "      \"slots\": [],\n" +
            "      \"dependents\": [\n" +
            "        \"bal-button\"\n" +
            "      ],\n" +
            "      \"dependencies\": [],\n" +
            "      \"dependencyGraph\": {\n" +
            "        \"bal-button\": [\n" +
            "          \"bal-spinner\"\n" +
            "        ]\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}\n";

    public static StencilDoc deserialize() throws FileNotFoundException {
        Gson gson = new Gson();
        StencilDoc stencilDoc = gson.fromJson(StencilDocReader.content, StencilDoc.class);
        System.out.println("hallo");
        return stencilDoc;
    }

}
