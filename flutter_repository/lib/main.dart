import 'package:flutter/material.dart';
import 'package:flutter_repository/router.dart';
import 'package:flutter_repository/src/example/MyHomePage.dart';
import 'package:go_router/go_router.dart';

/// Flutter页面的入口方法
void main() async {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _MyAppPageState();
  }
}

class _MyAppPageState extends State<MyApp> {
  GlobalKey<NavigatorState> navigatorKey = GlobalKey<NavigatorState>();

  @override
  Widget build(BuildContext context) {
    goRouter() {
      List<RouteBase> routes = [
        GoRoute(
          path: '/',
          builder: (context, state) => const MyHomePage(title: "Flutter Demo Home Page"),
        ),
      ];
      routes.addAll(businessRoutes);

      return GoRouter(
        routes: routes,
        navigatorKey: navigatorKey,
        // observers: [QRRouteObserver()],  // 路由监听
      );
    }

    RouterConfig<Object>? route = goRouter();

    return MediaQuery(
      data: MediaQuery.of(context)
          .copyWith(textScaleFactor: 1.0, boldText: false, highContrast: true),
      child: Container(
        width: MediaQuery.of(context).size.width,
        height: MediaQuery.of(context).size.height,
        child: MaterialApp.router(
          routerConfig: route,
          color: Colors.transparent,
        ),
      ),
    );
  }
}
