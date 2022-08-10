@echo off

net start com.docker.service

git merge origin/validate

docker run -v "%cd%:/src" returntocorp/semgrep semgrep --config=src/test/java/com/de/dhbw/ravensburg/myonlineshopdatabase/thymeleafTests/ruleGrid.yml src/main/resources/templates/fragments/grid.html --output scan_results_gridHTML.vim --vim
docker run -v "%cd%:/src" returntocorp/semgrep semgrep --config=src/test/java/com/de/dhbw/ravensburg/myonlineshopdatabase/thymeleafTests/ruleMain.yml src/main/resources/templates/main.html --output scan_results_mainHTML.vim --vim
docker run -v "%cd%:/src" returntocorp/semgrep semgrep --config=src/test/java/com/de/dhbw/ravensburg/myonlineshopdatabase/thymeleafTests/ruleController.yml src/main/java/com/de/dhbw/ravensburg/myonlineshopdatabase/controller/ThCarControllerImpl.java --output scan_results_ThControllerImpl.vim --vim

docker run -v "%cd%:/src" returntocorp/semgrep semgrep --config=src/test/java/com/de/dhbw/ravensburg/myonlineshopdatabase/validierung/validierungAufgabe1Rule.yml src/main/java/com/de/dhbw/ravensburg/myonlineshopdatabase/dto/CarDTO.java --output scan_results_CarDTO1.vim --vim
docker run -v "%cd%:/src" returntocorp/semgrep semgrep --config=src/test/java/com/de/dhbw/ravensburg/myonlineshopdatabase/validierung/validierungAufgabe2Rule.yml src/main/java/com/de/dhbw/ravensburg/myonlineshopdatabase/dto/CarDTO.java --output scan_results_CarDTO2.vim --vim

docker run -v "%cd%:/src" returntocorp/semgrep semgrep --config=src/test/java/com/de/dhbw/ravensburg/myonlineshopdatabase/RestTests/aufgabe2/ruleAddOwner.yml src/test/java/com/de/dhbw/ravensburg/myonlineshopdatabase/RestController/OwnerRestControllerUTTest.java --output scan_results_AddOwner.vim --vim
docker run -v "%cd%:/src" returntocorp/semgrep semgrep --config=src/test/java/com/de/dhbw/ravensburg/myonlineshopdatabase/RestTests/aufgabe2/ruleGetOwner.yml src/test/java/com/de/dhbw/ravensburg/myonlineshopdatabase/RestController/OwnerRestControllerUTTest.java --output scan_results_GetOwner.vim --vim

find /C "match" "scan_results_gridHTML.vim" > results.txt
find /C "match" "scan_results_mainHTML.vim" >> results.txt
find /C "match" "scan_results_ThControllerImpl.vim" >> results.txt

find /C "match" "scan_results_CarDTO1.vim" >> results.txt
find /C "match" "scan_results_CarDTO2.vim" >> results.txt

find /C "match" "scan_results_AddOwner.vim" >> results.txt
find /C "match" "scan_results_GetOwner.vim" >> results.txt

call ./mvnw test --log-file maven-test-results.txt

cd target
cd surefire-reports

findstr Skipped com.de.dhbw.ravensburg.myonlineshopdatabase.thymeleafTests.indexTest.txt >> ../../results.txt
findstr Skipped com.de.dhbw.ravensburg.myonlineshopdatabase.thymeleafTests.indexDataTest.txt >> ../../results.txt
findstr Skipped com.de.dhbw.ravensburg.myonlineshopdatabase.thymeleafTests.mainTest.txt >> ../../results.txt
findstr Skipped com.de.dhbw.ravensburg.myonlineshopdatabase.thymeleafTests.ThCarControllerImplTest.txt >> ../../results.txt

findstr Skipped com.de.dhbw.ravensburg.myonlineshopdatabase.Restcontroller.OwnerRestControllerUTTest.txt >>../../results.txt
findstr Skipped com.de.dhbw.ravensburg.myonlineshopdatabase.RestTests.aufgabe1.ControllerITTest.txt >> ../../results.txt
findstr Skipped com.de.dhbw.ravensburg.myonlineshopdatabase.RestTests.aufgabe1.ControllerUTTest.txt >> ../../results.txt
findstr Skipped com.de.dhbw.ravensburg.myonlineshopdatabase.RestTests.aufgabe1.ServiceITTest.txt >> ../../results.txt

REM organize
cd ../..

REM THYMELEAF
set result_grid=
for /f "delims=" %%i in ('findstr SCAN_RESULTS_GRIDHTML results.txt') do (
    set result_grid=%%i
 )
SET var_grid=%result_grid:~-1%

set result_cont=
for /f "delims=" %%i in ('findstr SCAN_RESULTS_THCONTROLLERIMPL results.txt') do (
    set result_cont=%%i
 )
SET var_cont=%result_cont:~-1%

set result_main=
for /f "delims=" %%i in ('findstr SCAN_RESULTS_MAINHTML results.txt') do (
    set result_main=%%i
 )
SET var_main=%result_main:~-1%

Set /A semp_thy=%var_grid% + %var_cont% + %var_main%


REM Validierung
set result_cardto1=
for /f "delims=" %%i in ('findstr SCAN_RESULTS_CARDTO1 results.txt') do (
    set result_cardto1=%%i
 )
SET var_carto1=%result_cardto1:~-1%

set result_cardto2=
for /f "delims=" %%i in ('findstr SCAN_RESULTS_CARDTO2 results.txt') do (
    set result_cardto2=%%i
 )
SET var_carto2=%result_cardto2:~-1%

Set /A semp_val=%var_carto1% + %var_carto2%


REM Rest
set result_addOwner=
for /f "delims=" %%i in ('findstr SCAN_RESULTS_ADDOWNER results.txt') do (
    set result_addOwner=%%i
 )
SET var_addOwner=%result_addOwner:~-1%

set result_getOwner=
for /f "delims=" %%i in ('findstr SCAN_RESULTS_GETOWNER results.txt') do (
    set result_getOwner=%%i
 )
SET var_getOwner=%result_getOwner:~-1%

Set /A semp_rest=%var_addOwner% + %var_getOwner%


REM Junit Thymeleaf
set result_indexTest=
for /f "delims=" %%i in ('findstr thymeleafTests.indexTest results.txt') do (
    set result_indexTest=%%i
 )
SET var_indexTest=%result_indexTest:~24,1%

set result_indexDataTest=
for /f "delims=" %%i in ('findstr thymeleafTests.indexDataTest results.txt') do (
    set result_indexDataTest=%%i
 )
SET var_indexDataTest=%result_indexDataTest:~24,1%

set result_mainTest=
for /f "delims=" %%i in ('findstr thymeleafTests.mainTest results.txt') do (
    set result_mainTest=%%i
 )
SET var_mainTest=%result_mainTest:~24,1%

set result_contTest=
for /f "delims=" %%i in ('findstr thymeleafTests.ThCarControllerImplTest results.txt') do (
    set result_contTest=%%i
 )
SET var_contTest=%result_contTest:~24,1%

Set /A junit_thymeleaf=%var_indexTest% + %var_indexDataTest% + %var_mainTest% + %var_contTest%

REM Junit Rest
set result_ResUTTest=
for /f "delims=" %%i in ('findstr OwnerRestControllerUTTest results.txt') do (
    set result_ResUTTest=%%i
 )
SET var_ResUTTest=%result_ResUTTest:~24,1%

set result_ContITTest=
for /f "delims=" %%i in ('findstr ControllerITTest results.txt') do (
    set result_ContITTest=%%i
 )
SET var_ContITTest=%result_ContITTest:~24,1%

set result_ContUTTest=
for /f "delims=" %%i in ('findstr ControllerUTTest results.txt') do (
    set result_ContUTTest=%%i
 )
SET var_ContUTTest=%result_ContUTTest:~24,1%

set result_ServiceITTest=
for /f "delims=" %%i in ('findstr ServiceITTest results.txt') do (
    set result_ServiceITTest=%%i
 )
SET var_ServiceITTest=%result_ServiceITTest:~24,1%

Set /A junit_rest=%var_ResUTTest% + %var_ContITTest% + %var_ContUTTest% + %var_ServiceITTest%

echo: >> results.txt
echo Errors >> results.txt
echo Junit Thymeleaf %junit_thymeleaf%/10 >> results.txt
echo Junit Rest %junit_rest%/6 >> results.txt

echo: >> results.txt
echo Correct Approach >> results.txt
echo semgrep Thymeleaf %semp_thy%/8 >> results.txt
echo semgrep Rest %semp_rest%/8 >> results.txt
echo semgrep Validierung %semp_val%/16 >> results.txt