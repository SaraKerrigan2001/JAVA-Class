# TiendaCarro

Proyecto Java MVC simple para gestionar datos de choferes, carros, motores y pasajeros.

## Ejecutar

1. Compilar:
   ```powershell
   javac -d bin src\tiendacarro\Main\TiendaParking.java src\tiendacarro\Controlador\controlador_general.java src\tiendacarro\Servicio\RegistroServicio.java src\tiendacarro\Modelo\*.java src\tiendacarro\Vista\*.java
   ```
2. Ejecutar:
   ```powershell
   java -cp bin tiendacarro.Main.TiendaParking
   ```

## Ignorar

Se excluye:
- `bin/`
- `*.class`
- `.vscode/`
- `nbproject/`
- archivos de IDE
