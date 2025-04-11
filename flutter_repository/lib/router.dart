import 'package:flutter_repository/src/example/TestPage1.dart';
import 'package:flutter_repository/src/example/TestPage2.dart';
import 'package:go_router/go_router.dart';

/// 路由列表
final businessRoutes = [
  GoRoute(
    path: "/testPage1",
    builder: (context, state) => const TestPage1(),
  ),
  GoRoute(
    path: "/testPage2",
    builder: (context, state) => const TestPage2(),
  ),
];
