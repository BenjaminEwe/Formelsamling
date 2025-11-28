# For XeLaTeX
$pdf_mode = 1;
$xelatex = 'xelatex -synctex=1 -interaction=nonstopmode -file-line-error';
$out_dir = 'generated';
$aux_dir = 'generated';

# Copy PDF to main directory after successful compilation
$success_cmd = 'cmd /C copy /Y "generated\\%R.pdf" "%R.pdf"';
$failure_cmd = 'cmd /C echo "Compilation failed"';

