# TiendaCarro

Proyecto Java MVC simple para gestionar datos de choferes, carros, motores y pasajeros.

## Ejecutar

1. Compilar:
   ```powershell
   javac -d bin src\Main\TiendaCarro.java src\Controlador\general_controller.java src\Modelo\*.java src\Vista\*.java
   ```
2. Ejecutar:
   ```powershell
   java -cp bin tiendacarro.Main.TiendaCarro
   ```

## Ignorar

Se excluye:
- `bin/`
- `*.class`
- `.vscode/`
- `nbproject/`
- archivos de IDE
