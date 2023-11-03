The following files in the plcc.pithon.net JNotes-src directory must be made
executable when copied to an environment such as Linux that supports LaTex.

    Base/ListTexFiles
    Base/MakeMasterTexFile
    MakeSlides
    */MakeSlides

Since the plcc.pithon.net repository does not preserve executable privileges,
you must modify the privileges of these files prior to creating the PDF files.

To make the PDF file for slide set X, for example, use the following command:

    ./MakeSlides X

This will work for slide sets 0, 1, 1a, 2, 3, 3a, 4, 5, 6, 7, and 8. You can
also make the slides for a particular set X *inside the X directory* with the
command

    ./MakeSlides

For example, inside directory 3a you can run

    ./MakeSlides

to create the slides-3a.pdf file.
