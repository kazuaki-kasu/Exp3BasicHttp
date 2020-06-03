import http.server
import socketserver
import datetime

PORT = 80
Handler = http.server.SimpleHTTPRequestHandler

with socketserver.TCPServer(("", PORT), Handler) as httpd:
    print("Hello: BasicHTTP!")
    Date = datetime.datetime.now()
    print("日付け:"+ Date.strftime('%Y年%m月%d日 %H:%M:%S'))
    httpd.serve_forever()