# PackageFile

`JAVA Swing program help people people to pick file and put them together in one time`

## 操作說明
- 來源路徑: 指定本機檔案來源路徑
`D:\project\workspace\web_moi_kcg`
- 目標路徑: 指定推送檔案目的地路徑
`\\127.0.0.1\moiland\webapp`
- 檔案位置: 輸入檔案名稱,可以用';'符號切分多個檔案
`WEB-INF\src\...\AjaxReport.java;ADM\ASL05\ASL0502.jsp `

## 功能說明
- 輸入檔案位置: 提供可批次輸入本機來源路徑，依檔案位置欄位內容，批次列於檔案列表
- 從來源路徑匯入清單: 提供匯入自指定來源路徑目錄下的檔案清單(自動探索子目錄)
- 推送檔案: 提供可批次輸入本機來源路徑，依檔案列表的檔案清單內容，推送至目標路徑
- 清除列表: 清空檔案列表內容
- 匯入純文字檔: 以純文字檔案，將檔案內容匯入至檔案列表中
- 切換原始/執行檔: 切換 java / classes 路徑  
`src←→classes，java←→class`
- 加減WebRoot: 在檔案列表中每列前方加上'WebRoot\前輟  
`WEB-INF←→WebRoot\\WEB-INF`
- 加減webapp: 在檔案列表中每列前方加上'webapp\前輟
`WEB-INF←→webapp\\WEB-INF`
- 匯出Bat檔: 將輸入的檔案例表打包功能，匯出成可於Windows環境下獨力執行的.bat檔

## 提醒說明
- 若有重複檔案，此程式將自行覆蓋，請小心使用。
- 若目標路徑為AP Server 等網路路徑，請先透過Windows檔案總管訪問，通過登入驗證後再做推送