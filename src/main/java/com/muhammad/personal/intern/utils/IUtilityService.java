package com.muhammad.personal.intern.utils;

import java.awt.*;
import java.io.IOException;
import java.util.Date;

public interface IUtilityService {
    int dobConversion(Date date);
    Image readImageFromPath(String path) throws IOException;
    String WriteImageToFile(Image image);
}
