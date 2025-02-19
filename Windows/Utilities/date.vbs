' Copy datetime to clipboard.
Dim dd, mm, yy, hh, nn, ss
Dim datevalue, timevalue, dtsnow, dtsvalue
Dim WshShell, BtnCode
Set WshShell = WScript.CreateObject("WScript.Shell")
Set WshShell = CreateObject("WScript.Shell")
Set oExec = WshShell.Exec("clip")
Set oIn = oExec.stdIn
'Store DateTimeStamp once.
dtsnow = Now()

'Individual date components
dd = Right("00" & Day(dtsnow), 2)
mm = Right("00" & Month(dtsnow), 2)
yy = Year(dtsnow)
hh = Right("00" & Hour(dtsnow), 2)
nn = Right("00" & Minute(dtsnow), 2)
ss = Right("00" & Second(dtsnow), 2)

'Build the date string in the format yyyy-mm-dd
datevalue = yy & "-" & mm & "-" & dd
'Build the time string in the format hh:mm:ss
timevalue = hh & ":" & nn & ":" & ss
'Concatenate both together to build the timestamp yyyy-mm-dd hh:mm:ss
dtsvalue = datevalue & " " & timevalue
'oIn.WriteLine "**-------------------------------END----------------------------------------**"
oIn.WriteLine dtsvalue
'oIn.WriteLine "||-------------------------------BEGIN--------------------------------------||"
oIn.Close

' Open application shortcuts
Set WshShell = WScript.CreateObject("WScript.Shell")

' Open command prompt 
WshShell.Run "C:\WINDOWS\system32\cmd.exe /k ""C:\Users\rashe15\AppData\Local\Google\Cloud SDK\cloud_env.bat"" "
WScript.Sleep 3000 ' Wait for application to open

' Type some text
WshShell.SendKeys "gcloud cloud-shell ssh"
WshShell.SendKeys "{ENTER}"
