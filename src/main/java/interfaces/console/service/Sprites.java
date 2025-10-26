package interfaces.console.service;

public class Sprites {
    public static final int HEIGHT = 8;
    public static final String PADDING = "        ";
    private static final String PIPE = "█";
    private static final String SPACE  = "  ";
    private static final String DIVISOR_SPACE = "▀▀";

    public static final String[] X = {
            SPACE           + "        "+ SPACE          + PIPE,
            SPACE           + " ██   ██"+ SPACE          + PIPE,
            SPACE           + "  ██ ██ "+ SPACE          + PIPE,
            SPACE           + "   ███  "+ SPACE          + PIPE,
            SPACE           + "  ██ ██ "+ SPACE          + PIPE,
            SPACE           + " ██   ██"+ SPACE          + PIPE,
            SPACE           + "        "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] X_ROW_WIN = {
            SPACE           + "        "+ SPACE          + PIPE,
            SPACE           + " ██   ██"+ SPACE          + PIPE,
            SPACE           + "  ██ ██ "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀███▀▀"+ DIVISOR_SPACE  + PIPE,
            SPACE           + "  ██ ██ "+ SPACE          + PIPE,
            SPACE           + " ██   ██"+ SPACE          + PIPE,
            SPACE           + "        "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] X_COL_WIN = {
            SPACE           + "    █   "+ SPACE          + PIPE,
            SPACE           + " ██ █ ██"+ SPACE          + PIPE,
            SPACE           + "  █████ "+ SPACE          + PIPE,
            SPACE           + "   ███  "+ SPACE           + PIPE,
            SPACE           + "  █████ "+ SPACE          + PIPE,
            SPACE           + " ██ █ ██"+ SPACE          + PIPE,
            SPACE           + "    █   "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀█▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] X_DIA_1_WIN = {
            "▀▀"            + "█       "+ SPACE          + PIPE,
            SPACE           + " ██   ██"+ SPACE          + PIPE,
            SPACE           + "  ██ ██ "+ SPACE          + PIPE,
            SPACE           + "   ███  "+ SPACE          + PIPE,
            SPACE           + "  ██ ██ "+ SPACE          + PIPE,
            SPACE           + " ██   ██"+ SPACE          + PIPE,
            SPACE           + "        "+ "▀█"           + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] X_DIA_2_WIN = {
            SPACE           + "       █"+ "▀▀"         + PIPE,
            SPACE           + " ██   ██"+ SPACE          + PIPE,
            SPACE           + "  ██ ██ "+ SPACE          + PIPE,
            SPACE           + "   ███  "+ SPACE          + PIPE,
            SPACE           + "  ██ ██ "+ SPACE          + PIPE,
            SPACE           + " ██   ██"+ SPACE          + PIPE,
            "█▀"            + "▀       "+ SPACE         + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] O = {
            SPACE           + "        "+ SPACE          + PIPE,
            SPACE           + " ██████ "+ SPACE          + PIPE,
            SPACE           + "██    ██"+ SPACE          + PIPE,
            SPACE           + "██    ██"+ SPACE          + PIPE,
            SPACE           + "██    ██"+ SPACE          + PIPE,
            SPACE           + " ██████ "+ SPACE          + PIPE,
            SPACE           + "        "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] O_ROW_WIN = {
            SPACE           + "        "+ SPACE          + PIPE,
            SPACE           + " ██████ "+ SPACE          + PIPE,
            SPACE           + "██    ██"+ SPACE          + PIPE,
            DIVISOR_SPACE   + "██▀▀▀▀██"+ DIVISOR_SPACE  + PIPE,
            SPACE           + "██    ██"+ SPACE          + PIPE,
            SPACE           + " ██████ "+ SPACE          + PIPE,
            SPACE           + "        "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] O_COL_WIN = {
            SPACE           + "    █   "+ SPACE          + PIPE,
            SPACE           + " ██████ "+ SPACE          + PIPE,
            SPACE           + "██  █ ██"+ SPACE          + PIPE,
            SPACE           + "██  █ ██"+ SPACE          + PIPE,
            SPACE           + "██  █ ██"+ SPACE          + PIPE,
            SPACE           + " ██████ "+ SPACE          + PIPE,
            SPACE           + "    █   "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀█▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] O_DIA_1_WIN = {
            "▀▀"            + "█       "+ SPACE          + PIPE,
            SPACE           + " ██████ "+ SPACE          + PIPE,
            SPACE           + "███   ██"+ SPACE          + PIPE,
            SPACE           + "██ █  ██"+ SPACE          + PIPE,
            SPACE           + "██  █ ██"+ SPACE          + PIPE,
            SPACE           + " ██████ "+ SPACE          + PIPE,
            SPACE           + "       ▀"+ "▀█"           + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] O_DIA_2_WIN = {
            SPACE           + "       █"+ "▀▀"           + PIPE,
            SPACE           + " ██████ "+ SPACE          + PIPE,
            SPACE           + "██   ███"+ SPACE          + PIPE,
            SPACE           + "██  █ ██"+ SPACE          + PIPE,
            SPACE           + "██ █  ██"+ SPACE          + PIPE,
            SPACE           + " ██████ "+ SPACE          + PIPE,
            "█▀"            + "▀       "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] ONE = {
            SPACE           + "        "+ SPACE          + PIPE,
            SPACE           + "    ██  "+ SPACE          + PIPE,
            SPACE           + "   ███  "+ SPACE          + PIPE,
            SPACE           + "    ██  "+ SPACE          + PIPE,
            SPACE           + "    ██  "+ SPACE          + PIPE,
            SPACE           + "    ██  "+ SPACE          + PIPE,
            SPACE           + "        "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] TWO = {
            SPACE           + "        "+ SPACE          + PIPE,
            SPACE           + " ██████ "+ SPACE          + PIPE,
            SPACE           + "      ██"+ SPACE          + PIPE,
            SPACE           + "  █████ "+ SPACE          + PIPE,
            SPACE           + " ██     "+ SPACE          + PIPE,
            SPACE           + " ███████"+ SPACE          + PIPE,
            SPACE           + "        "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] THREE = {
            SPACE           + "        "+ SPACE          + PIPE,
            SPACE           + " ██████ "+ SPACE          + PIPE,
            SPACE           + "      ██"+ SPACE          + PIPE,
            SPACE           + "  █████ "+ SPACE          + PIPE,
            SPACE           + "      ██"+ SPACE          + PIPE,
            SPACE           + " ██████ "+ SPACE          + PIPE,
            SPACE           + "        "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] FOUR = {
            SPACE           + "        "+ SPACE          + PIPE,
            SPACE           + " ██   ██"+ SPACE          + PIPE,
            SPACE           + " ██   ██"+ SPACE          + PIPE,
            SPACE           + " ███████"+ SPACE          + PIPE,
            SPACE           + "      ██"+ SPACE          + PIPE,
            SPACE           + "      ██"+ SPACE          + PIPE,
            SPACE           + "        "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] FIVE = {
            SPACE           + "        "+ SPACE          + PIPE,
            SPACE           + " ███████"+ SPACE          + PIPE,
            SPACE           + " ██     "+ SPACE          + PIPE,
            SPACE           + " ███████"+ SPACE          + PIPE,
            SPACE           + "      ██"+ SPACE          + PIPE,
            SPACE           + " ███████"+ SPACE          + PIPE,
            SPACE           + "        "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] SIX = {
            SPACE           + "        "+ SPACE          + PIPE,
            SPACE           + " ██████ "+ SPACE          + PIPE,
            SPACE           + " ██     "+ SPACE          + PIPE,
            SPACE           + " ███████"+ SPACE          + PIPE,
            SPACE           + " ██    ██"+ SPACE          + PIPE,
            SPACE           + "  ██████ "+ SPACE          + PIPE,
            SPACE           + "        "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] SEVEN = {
            SPACE           + "        "+ SPACE          + PIPE,
            SPACE           + " ███████"+ SPACE          + PIPE,
            SPACE           + "      ██"+ SPACE          + PIPE,
            SPACE           + "     ██ "+ SPACE          + PIPE,
            SPACE           + "    ██  "+ SPACE          + PIPE,
            SPACE           + "    ██  "+ SPACE          + PIPE,
            SPACE           + "        "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] EIGHT = {
            SPACE           + "        "+ SPACE          + PIPE,
            SPACE           + "  █████ "+ SPACE          + PIPE,
            SPACE           + " ██   ██"+ SPACE          + PIPE,
            SPACE           + "  █████ "+ SPACE          + PIPE,
            SPACE           + " ██   ██"+ SPACE          + PIPE,
            SPACE           + "  █████ "+ SPACE          + PIPE,
            SPACE           + "        "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };

    public static final String[] NINE = {
            SPACE           + "        "+ SPACE          + PIPE,
            SPACE           + "  █████ "+ SPACE          + PIPE,
            SPACE           + " ██   ██"+ SPACE          + PIPE,
            SPACE           + "  ██████"+ SPACE          + PIPE,
            SPACE           + "      ██"+ SPACE          + PIPE,
            SPACE           + "  █████ "+ SPACE          + PIPE,
            SPACE           + "        "+ SPACE          + PIPE,
            DIVISOR_SPACE   + "▀▀▀▀▀▀▀▀"+ DIVISOR_SPACE  + PIPE,
    };
}
