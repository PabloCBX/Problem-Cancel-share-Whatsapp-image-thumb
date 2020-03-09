  private void saveBitmap(Bitmap bitmap) {
    
        String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
    
        String dateFormat1 = mydate.replace("/","").replace(":",""); 
        //Important!!! This provide a dinamic name to the image and replace the last capture.
        //Importante!!! Esto permite un nombre dinamico y reemplaza la ultima captura.

        String name_img = getResources().getString(R.string.name_path);

        String filePath = Environment.getExternalStorageDirectory()
                + File.separator + name_img + dateFormat1 + ".png"; 
          // The new name never repeat.
          // El nuevo nombre nunca se repetirá.

        File imagePath = new File(filePath);

        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            shareVerse(filePath);
        } catch (FileNotFoundException e) {
            Log.e("MSG", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("MSG", e.getMessage(), e);
        }
    }
