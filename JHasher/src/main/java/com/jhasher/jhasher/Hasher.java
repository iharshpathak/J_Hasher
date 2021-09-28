/* J Hasher - A FOSS JavaFx Application For Hashing texts, Files & Validating hash of files.
    Copyright (C) 2021  Harsh Pathak

    J Hasher is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.*/

package com.jhasher.jhasher;

import jakarta.xml.bind.DatatypeConverter;

import java.io.File;
import java.nio.file.Files;
import java.security.MessageDigest;

public class Hasher {
    private  byte [] input;
    private  String algorithm ="";


    public void setValues(String inp, String al){
        this.input=inp.getBytes();
        this.algorithm=al;
    }
    public String ShHasher(){
        String hashValue="";
        try{
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(input);
            byte[] digestedBytes = messageDigest.digest();
            hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
        }
        catch (Exception e){ //
        }
        return hashValue;

    }
    public String FileHasher(String fpath, String alGo){
        String str="";
        try{
            File fFile = new File(fpath);
            this.input= Files.readAllBytes(fFile.toPath());
            this.algorithm=alGo;
            str = ShHasher();
        }catch (Exception e){
            //
        }
        return str;
    }
}

