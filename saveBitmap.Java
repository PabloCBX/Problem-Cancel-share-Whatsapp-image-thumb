  public void saveBitmap(Bitmap bitmap) {
    
        String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
    
        String dateFormat1 = mydate.replace("/","").replace(":",""); //Important!!! This provide a dinamic name to the image.

        String name_img = getResources().getString(R.string.name_path);

        String filePath = Environment.getExternalStorageDirectory()
                + File.separator + name_img + dateFormat1 + ".png"; // New name not repeat the last persist image.

        File imagePath = new File(filePath);

        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            shareVerse(filePath);
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }
